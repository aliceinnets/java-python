package aliceinnets.python;

public class Add {
	public final static int SCALAR = 0;
	public final static int ARRAY = 1;
	public final static int MATRIX = 2;
	public final static int UNDEFINED = -1;
	
	
	int dim1;
	int dim2;
	
	double scalar1;
	double[] array1;
	double[][] matrix1;
	double scalar2;
	double[] array2;
	double[][] matrix2;
	
	
	public Add(Object arg1, Object arg2) {
		setArg1(arg1);
		setArg2(arg2);
	}
	
	
	public void setArg1(Object arg1) {
		dim1 = UNDEFINED;
		scalar1 = 0;
		array1 = null;
		matrix1 = null;
		
		if(arg1 instanceof Double) {
			scalar1 = (double) arg1;
			dim1 = SCALAR;
		} else if(arg1 instanceof double[]) {
			array1 = (double[]) arg1;
			dim1 = ARRAY;
		} else if(arg1 instanceof double[][]) {
			matrix1 = (double[][]) arg1;
			dim1 = MATRIX;
		}
		
	}
	
	
	public void setArg2(Object arg2) {
		dim2 = UNDEFINED;
		scalar2 = 0;
		array2 = null;
		matrix2 = null;
		
		if(arg2 instanceof Double) {
			scalar2 = (double) arg2;
			dim2 = SCALAR;
		} else if(arg2 instanceof double[]) {
			array2 = (double[]) arg2;
			dim2 = ARRAY;
		} else if(arg2 instanceof double[][]) {
			matrix2 = (double[][]) arg2;
			dim2 = MATRIX;
		}
	}
	
	
	public double eval() {
		if(dim1 == SCALAR && dim2 == SCALAR) {
			return scalar1+scalar2;
		} else {
			throw new RuntimeException();
		}
	}
	
	
	public double[] evalArray() {
		if(dim1 == ARRAY && dim2 == SCALAR) {
			double[] ret = array1.clone();
			for (int i = 0; i < ret.length; i++) {
				ret[i] += scalar2;
			}
			return ret;
		} else if(dim2 == ARRAY && dim1 == SCALAR) {
			double[] ret = array2.clone();
			for (int i = 0; i < ret.length; i++) {
				ret[i] += scalar1;
			}
			return ret;
		} else if(dim1 == ARRAY && dim2 == ARRAY) {
			double[] ret = array1.clone();
			for (int i = 0; i < ret.length; i++) {
				ret[i] += array2[i];
			}
			return ret;
		} else {
			throw new RuntimeException();
		}
	}

}
