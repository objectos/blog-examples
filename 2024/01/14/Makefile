#
# objectos.library
#

## compile scope deps
COMPILE_DEPS  = $(DEPS)/org.slf4j/slf4j-api/1.7.36
COMPILE_DEPS += $(DEPS)/com.fasterxml.jackson.core/jackson-databind/2.16.1

#
# all: default goal
#

.PHONY: all
all: jar

#
# deps variables and functions
#

## local resolution dir
DEPS = resolution

## local repository directory
LOCAL_REPO_PATH = repository

## remote repository location
REMOTE_REPO_URL = https://repo.maven.apache.org/maven2

## split function
## splits string around the specified separator and returns nth word  
## 
## syntax:
## $(call split,[string],[separator],[n])
split = $(word $(3),$(subst $(2), ,$(1)))

## gav-local-repo function
## converts a single GAV into the corresponding local repository path
## 
## syntax:
## $(call gav-local-repo,[gav coordinate])
gav-local-repo1 = $(subst .,/,$(1))/$(2)/$(3)/$(2)-$(3).jar
gav-local-repo0 = $(call gav-local-repo1,$(call split,$(1),/,1),$(call split,$(1),/,2),$(call split,$(1),/,3))
gav-local-repo = $(LOCAL_REPO_PATH)/$(call gav-local-repo0,$(1))

## gavs-to-local
## converts a list of GAVs into a list of corresponding local repo paths
## 
## syntax:
## $(call gavs-to-local,[list of gavs])
gavs-to-local = $(foreach gav,$(1),$(call gav-local-repo,$(gav)))

## class-path function
## joins a list of strings using the class path separator
##
## syntax:
## $(call class-path,[list of deps])
CLASS_PATH_SEPARATOR = :
empty =
space = $(empty) $(empty)

class-path = $(subst $(space),$(CLASS_PATH_SEPARATOR),$(1))

## remote repo wget command
REMOTE_REPO_WGETX  = wget
REMOTE_REPO_WGETX += --directory-prefix=$(LOCAL_REPO_PATH)
REMOTE_REPO_WGETX += --force-directories
REMOTE_REPO_WGETX += --no-host-directories
REMOTE_REPO_WGETX += --cut-dirs=1
REMOTE_REPO_WGETX += --no-verbose

## download dependency rule:
$(LOCAL_REPO_PATH)/%.jar:	
	$(REMOTE_REPO_WGETX) $(@:$(LOCAL_REPO_PATH)/%.jar=$(REMOTE_REPO_URL)/%.jar)

#
# Resolver.java
#

## Resolver.java deps
RESOLVER_DEPS  = commons-codec/commons-codec/1.16.0
RESOLVER_DEPS += org.apache.commons/commons-lang3/3.12.0
RESOLVER_DEPS += org.apache.httpcomponents/httpclient/4.5.14
RESOLVER_DEPS += org.apache.httpcomponents/httpcore/4.4.16
RESOLVER_DEPS += org.apache.maven.resolver/maven-resolver-api/1.9.16
RESOLVER_DEPS += org.apache.maven.resolver/maven-resolver-connector-basic/1.9.16
RESOLVER_DEPS += org.apache.maven.resolver/maven-resolver-impl/1.9.16
RESOLVER_DEPS += org.apache.maven.resolver/maven-resolver-named-locks/1.9.16
RESOLVER_DEPS += org.apache.maven.resolver/maven-resolver-spi/1.9.16
RESOLVER_DEPS += org.apache.maven.resolver/maven-resolver-supplier/1.9.16
RESOLVER_DEPS += org.apache.maven.resolver/maven-resolver-transport-file/1.9.16
RESOLVER_DEPS += org.apache.maven.resolver/maven-resolver-transport-http/1.9.16
RESOLVER_DEPS += org.apache.maven.resolver/maven-resolver-util/1.9.16
RESOLVER_DEPS += org.apache.maven/maven-artifact/3.9.4
RESOLVER_DEPS += org.apache.maven/maven-builder-support/3.9.4
RESOLVER_DEPS += org.apache.maven/maven-model-builder/3.9.4
RESOLVER_DEPS += org.apache.maven/maven-model/3.9.4
RESOLVER_DEPS += org.apache.maven/maven-repository-metadata/3.9.4
RESOLVER_DEPS += org.apache.maven/maven-resolver-provider/3.9.4
RESOLVER_DEPS += org.codehaus.plexus/plexus-interpolation/1.26
RESOLVER_DEPS += org.codehaus.plexus/plexus-utils/3.5.1
RESOLVER_DEPS += org.slf4j/jcl-over-slf4j/1.7.36
RESOLVER_DEPS += org.slf4j/slf4j-api/1.7.36
RESOLVER_DEPS += org.slf4j/slf4j-nop/1.7.36

## Resolver local repo jars
RESOLVER_DEPS_JARS = $(call gavs-to-local,$(RESOLVER_DEPS))

## Resolver class-path
RESOLVER_CLASS_PATH = $(call class-path,$(RESOLVER_DEPS_JARS))

## Where to find our Resolver.java source 
RESOLVER_URL = https://raw.githubusercontent.com/objectos/objectos.mk/3ff20b750265bb1bbfd08c86e2418e7300d232d8/resolver/src/main/java/Resolver.java

## Resolver.java path
RESOLVER_JAVA = Resolver.java

$(RESOLVER_JAVA): $(RESOLVER_DEPS_JARS)
	wget --no-verbose $(RESOLVER_URL) 

#
# resolution files creation
#

## resolve java command
RESOLVEX  = java
RESOLVEX += --class-path $(RESOLVER_CLASS_PATH)
RESOLVEX += $(RESOLVER_JAVA)
RESOLVEX += --local-repo $(LOCAL_REPO_PATH)
RESOLVEX += --resolution-dir $(DEPS)

$(DEPS)/%: $(RESOLVER_JAVA)
	$(RESOLVEX) $(@:$(DEPS)/%=%)

#
# clean
#

## work directory (all generated files go here)
WORK = work

.PHONY: clean
clean:
	rm -rf $(WORK)

$(WORK):
	@mkdir $@

#
# compile
#

## main source directory
MAIN = main

## all of our source files
SOURCES  = $(MAIN)/objectos/library/Hello.java
SOURCES += $(MAIN)/objectos/library/Hi.java
SOURCES += $(MAIN)/objectos/library/Say.java

## directory for the (main) compiled class files
CLASS_OUTPUT = $(WORK)/main

## class path file
COMPILE_CLASS_PATH = $(WORK)/compile-class-path

## compilation marker
COMPILE_MARKER = $(WORK)/compile-marker

## javac command options
JAVACX  = javac
JAVACX += -d $(CLASS_OUTPUT)
JAVACX += -g
JAVACX += --class-path @$(COMPILE_CLASS_PATH)
JAVACX += --source-path $(MAIN)
JAVACX += $(SOURCES)

$(COMPILE_CLASS_PATH): $(COMPILE_DEPS) | $(WORK)
ifneq ($(COMPILE_DEPS),)
	cat $^ | sort -u | paste --delimiter='$(CLASS_PATH_SEPARATOR)' --serial > $@
else
	touch $@
endif

$(COMPILE_MARKER): $(SOURCES) $(COMPILE_CLASS_PATH)
	$(JAVACX)
	@touch $@

#
# package
#

## JAR file name
JAR_FILE = $(WORK)/library.jar

## JAR command
JARX  = jar
JARX += --create
JARX += --file=$(JAR_FILE)
JARX += -C $(CLASS_OUTPUT)
JARX += .

.PHONY: jar
jar: $(JAR_FILE)

$(JAR_FILE): $(COMPILE_MARKER)
	$(JARX)
