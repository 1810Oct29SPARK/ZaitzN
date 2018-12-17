function getRecipes(){
    fetch("https://cors-anywhere.herokuapp.com/http://www.recipepuppy.com/api/?q=omelet")
    .then((response)=>{
        return response.json();
    })
    .then((data)=>{
        console.log(data);
        let recipes = data.results;
        let output = "";
        for (i = 0; i<recipes.length; i++){
            output +=`
                <div class="col-md-3">
                    <div class="well text-center">
                        <img src="${recipes[i].thumbnail}"/>
                        <h5>${recipes[i].title}</h5>
                        <a class="btn btn-success" href="${recipes[i].href}">Full Recipe</a>
                    </div>
                </div>
                `;
        }
        document.getElementById("recipes").innerHTML = output;
    })
}

document.getElementById("thebutton").addEventListener("click", getRecipes);