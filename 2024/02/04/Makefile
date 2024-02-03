#
# Copyright (C) 2024 Objectos Software LTDA.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

#
# all: default goal
#

.PHONY: all
all: compile

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
MAIN := main

## all of our source files
SOURCES := $(wildcard $(MAIN)/*.java)

## directory for the (main) compiled class files
CLASS_OUTPUT := $(WORK)/main

## compilation marker
COMPILE_MARKER := $(WORK)/compile-marker

## javac command options
JAVACX := javac
JAVACX += -d $(CLASS_OUTPUT)
JAVACX += -g
JAVACX += --source-path $(MAIN)
JAVACX += $(SOURCES)

.PHONY: compile
compile: $(COMPILE_MARKER)

$(COMPILE_MARKER): $(SOURCES)
	@$(JAVACX)
	@touch $@

#
# run
#

JAVAX := java
JAVAX += --class-path $(CLASS_OUTPUT)

.PHONY: run@%
run@%: $(COMPILE_MARKER)
	@$(JAVAX) objectos.$*
