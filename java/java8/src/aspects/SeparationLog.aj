package aspects;

import newfeatures.F4_StreamsAPI;

public aspect SeparationLog {

	pointcut separatorMethod():call(* F4_StreamsAPI.*() );

	before(): separatorMethod(){
		System.out.println("");
	}

}
