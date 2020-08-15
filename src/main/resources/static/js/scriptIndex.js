$(function(){
	
	let url_team="https://jquilcavaltask.herokuapp.com/rest/team";
	
	let url_tarea="https://jquilcavaltask.herokuapp.com/tareas";
	
	
		
	$("[data-toggle=popover]").popover();
	 $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
	        // save the latest tab; use cookies if you like 'em better:
	        localStorage.setItem('lastTab', $(this).attr('href'));
	    });
	
	 var lastTab = localStorage.getItem('lastTab');
	 
	    if (lastTab) {
	        $('[href="' + lastTab + '"]').tab('show');
	    }
		
	    
	 $('#boton-crear').click(function(e){
		 jQuery.validator.addMethod("noSpace", function(value, element) { 
	         return value == '' || value.trim().length != 0;  
	       }, "No se permiten espacios en blanco ");

		 
		$("#newModalForm").validate({
		    rules: {
		    	validationTeamName: {
		        required: true,
		        noSpace:true
		        
		      },
		      action: "required"
		    },
		    messages: {
		    	validationTeamName: {
		        required: "El campo no puede estar vacio",
		       
		      },
		      action: "Please provide some data"
		    },
		    submitHandler:async function(form) {
		    	let nombre_team=$('#validationTeamName').val();
				let id_usu_crear=$('#id_usu').val();
				
				let numeroAleatorio= Math.floor(100000 + Math.random()*(999999 + 1 - 100000));
				
		    	let team={
		    			id_team:numeroAleatorio,
		    			nombre_team:nombre_team,
		    			id_usu:id_usu_crear
		    	}
		    	
		    	
		    	
		    	await axios.post(url_team, team);
		    	
		    	
		    	
		    	
		    	//exampleModalCenter
		    	 $('#exampleModalCenter').modal('hide');
		    	 
		    	 
		    	 $("#team").reload("https://jquilcavaltask.herokuapp.com/tareas")
		    	 
		    	
		    	  
		    	 
	        	}
		 
		  });
		 
		 
			
				 
		})
	   
		 
	
		 $('#boton-unir').click(function(e){
		
 		
		 jQuery.validator.addMethod("noSpace", function(value, element) { 
	         return value == '' || value.trim().length != 0;  
	       }, "No se permiten espacios en blanco ");

		 
		$("#newModalUnir").validate({
		    rules: {
		    	codigo_team: {
		        required: true,
		        noSpace:true
		        
		      },
		      action: "required"
		    },
		    messages: {
		    	codigo_team: {
		        required: "El campo no puede estar vacio",
		       
		      },
		      action: "Please provide some data"
		    },
		    submitHandler:function(form) {
		    	
		    	let codigo_team=$('#codigo_team').val();
				let id_usu_unir=$('#id_usu').val();
				
				
		    	
		    	let unir_team={
		    			id_team:codigo_team,
		    			id_usu:id_usu_unir
		    			
		    	};
		    
		    	axios.put(url_team,unir_team ).then(response => {
		    		
		    		if(response.data==="ok"){
		    			//exampleModalCenter
				    	 $('#exampleModalCenter1').modal('hide');
				    	
				    	 
		    		}
		    		else{
		    			$('#exampleModalCenter1').modal('hide');
		    			alert("el codigo no existe");
		    		}
		    		
		    		
		        });
		    	
		    	
		    	 
		    	
		    }
		  });
		 
		
				 
		})
	   
		
	
	
	$(".tareaDescripcion").keyup(function(e){
			  e.preventDefault();
			  let tarea={};
			  
			  const $padre=$(e.currentTarget).parent();
			  //el hijo seria el checkbox
			  const $hijo=$padre.children()[0];
			  
			  console.log($padre);
			  console.log($hijo);
			  console.log(e.target.id+' '+e.target.value+'  '+$($hijo).children().is(":checked"));
			
			  tarea={
			    		id:e.target.id,
			    		descripcion:e.target.value,
			    		hecho:$($hijo).children().is(":checked")	 
			     		}
			  
			  axios.put(url_tarea, tarea).then(response => {
		    		console.log(response.data)
		    		
		        });
			 
		  });  
	    
   $(".checkbox-tarea").click(function(e){
		 
		  
		  if(e.target.id!=""){
			 
			  let tarea={};
			  console.log('haz tocado el checkbox-tarea');
			  
			  const $padre=$(e.currentTarget).parent();

			  const $padreSuperio=$($padre).parent();
			  //el hijo seria la descripcion
			  const $hijo=$padreSuperio.children()[1];
			  
			  console.log(e.target.id+' '+$($hijo).children().val()+'  '+$(e.target).is(":checked"));
			  
			  tarea={
			    		id:e.target.id,
			    		descripcion:$($hijo).children().val(),
			    		hecho:$(e.target).is(":checked")	 
			     		}
			  
			  axios.put(url_tarea, tarea).then(response => {
		    		console.log(response.data)
		    		
		        });
			  
		  	}
		  
		
	  }); 
   
 
   
   


   
	  
   
   
});
