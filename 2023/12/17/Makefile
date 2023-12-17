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

## directory for the (main) compiled class files
CLASS_OUTPUT = $(WORK)/main

## javac command options
JAVACX = javac
JAVACX += -d $(CLASS_OUTPUT)
JAVACX += $<

work/main/objectos/library/Say.class: main/objectos/library/Say.java
	$(JAVACX)

#
# package
#

## JAR file name
JAR_FILE = $(WORK)/library.jar

## JAR command
JARX = jar
JARX += --create
JARX += --file=$(JAR_FILE)
JARX += -C $(CLASS_OUTPUT)
JARX += .

.PHONY: jar
jar: $(JAR_FILE)

$(JAR_FILE): work/main/objectos/library/Say.class
	$(JARX)
