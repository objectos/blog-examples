#
# all: default goal
#

.PHONY: all
all: jar

#
# clean
#

## work directory (all generated files go here)
WORK = work

.PHONY: clean
clean:
	rm -rf $(WORK)

#
# compile
#

## main source directory
MAIN = main

## all of our source files
#SOURCES  = $(MAIN)/objectos/library/Hello.java
#SOURCES += $(MAIN)/objectos/library/Hi.java
#SOURCES += $(MAIN)/objectos/library/Say.java
SOURCES += $(wildcard $(MAIN)/**/**/*.java)

## directory for the (main) compiled class files
CLASS_OUTPUT = $(WORK)/main

## compilation marker
COMPILE_MARKER = $(WORK)/compile-marker

## javac command options
JAVACX  = javac
JAVACX += -d $(CLASS_OUTPUT)
JAVACX += -g
JAVACX += --source-path $(MAIN)
JAVACX += $^

$(COMPILE_MARKER): $(SOURCES)
	rm -rf $(CLASS_OUTPUT)
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

