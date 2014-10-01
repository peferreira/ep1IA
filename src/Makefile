JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
        $(JC) $(JFLAGS) $*.java

CLASSES = \
        AstarComparator.java \
        Busca.java \
        BuscaAStar.java \
        BuscaCustoUniforme.java \
		BuscaEmLargura.java \
		BuscaEmProfundidade.java \
		BuscaProfundidadeIterativa.java \
		BuscaProfundidadeLimitada.java \
		EstadoDoPuzzle.java 
        GerenciadorDeBuscas.java \
        PriorityQueueComparator.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
        $(RM) *.class