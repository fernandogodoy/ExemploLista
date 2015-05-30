package br.exemplo.lista;

import java.util.ArrayList;

/**
 * Exemplo desenvolvido para exemplificar comportamentos existentes em um {@link ArrayList}
 * 
 * @author Fernando Godóy
 *
 */
public class ListaAlocacaoDinamica {

	private static final int FIRST_POSITION = 0;

	/**
	 * Capacidade de armazenamento padrão da lista
	 */
	private static final Integer DEFAULT_VALUE = 10;
	
	/**
	 * Armazena a posição do último item inserido na lista
	 */
    private Integer currentPosition;
    
    /**
     * Armazena a capacidade de armazenamento quantida de posições disponíveis
     */
    private Integer availablePositions;
    
    /**
     * Array onde os itens são armazenados
     */
    private String[] array;
    

    /**
     * Construtor padrão 
     * 
     */
    public ListaAlocacaoDinamica() {
        array = new String[DEFAULT_VALUE];
        availablePositions = DEFAULT_VALUE;
        currentPosition = FIRST_POSITION;
       
    }

    /**
     * Responsável pela adição de valores a lista.</br>
     * Sempre que um novo item for inserido na lista o valor da posição atual
     * será incrementado uma posição na posição atual, que passará a ter o valor do próximo item a ser inserido, 
     * além de diminuir um posição disponível.
     * 
     * 
     * @param texto
     * 
     */
    public void add(String value) {
    	checkAvailableLimit();
        array[currentPosition] = value;
        currentPosition++;
        availablePositions--;
    }

    /**
     * Responsável pela remoção de itens da lista e reordenação do itens posicionados a frente uma casa pra trás,
     * desta forma não ficará buracos no meio da lista
     * 
     * @param index  posição onde se encontra o item a ser removido
     */
    public void remove(Integer index) {
    	for(int x = index; x < currentPosition; x++){
    		array[x] = array[x + 1];
    	}
    	currentPosition --;
        availablePositions++;
    }

    /**
     * Responsável por verificar se será necessário aumentar a capacidade do array
     */
    private void checkAvailableLimit() {
        if (availablePositions == 0) {
           upgradeCapacity();
        }
    }

    /**
     * Responsável por aumentar o tamanho do array sempre que necessário a inserção de um novo item e o array
     * não contenha posições disponíveis para armazear o item
     * 
     * @return
     */
    private void upgradeCapacity() {
        array = copyArrayValues();
        availablePositions = + DEFAULT_VALUE;
    }

    /**
     * Copia os valores existente no array, para um novo array
     * 
     * @param newArray array que receberá os valores já armazenados noa array
     */
	private String[] copyArrayValues() {
		String[] newArray = new String[currentPosition + DEFAULT_VALUE];
		for(int x = FIRST_POSITION; x < currentPosition ; x++){
        	newArray[x] = array[x];
        }
		return newArray;
	}

    /**
     * Responsável por validar se a lista está vazia
     * 
     * @return {@link Boolean#TRUE} se não houver mais espaço para armazenamento na lista
     */
    public Boolean isEmpty() {
        return array.length == availablePositions;
    }

    /**
     * Retorna o valor armazendo na posição deseja.
     * 
     * @param index posição do item que se deseja
     * 
     * @return item encontrado na posição informada
     * 
     */
    public String get(Integer index) {
        return array[index];
    }

    /**
     * Resposável por retornar a quantidade de posições vazias na lista
     * 
     * @return Número de posições disponíveis 
     */
    public Integer size() {
        return availablePositions;
    }
    
    /**
     * Descreve o itens da lista em formato de texto, ordenados por ordem de inserção
     */
    @Override
    public String toString(){
    	String text = "";
    	if(!isEmpty()){
    		text = arrayPrint();
    	}
    	return text;
    }

    /**
     * Monta o texto a ser retornado
     * 
     * @return texto a ser exibido no {@link ListaAlocacaoDinamica#toString()}
     */
	private String arrayPrint() {
		String text;
		text = "[";
		for (int i = FIRST_POSITION; i < currentPosition; i++) {
			text += array[i] + ", ";
		}
		text = text.substring(0, text.length() - 2);
		text += "]";
		return text;
	}
}
