let state = {
    name: ''
};

const apiUrl = 'http://taco-randomizer.herokuapp.com/random/?full-taco=true';

let getTaco = function() {
    fetch(apiUrl)

    .then((response) => {

        return response.json();
    })

    .then((data) => {
        console.log(data);
        state.name = data.name;
        updateContent();

    })
}

let updateContent = function() {
    console.log(state);

    var node = document.createElement('li');
    var textnode = document.createTextNode(state.name);
    node.appendChild(textnode);
    document.getElementById('taco-list').appendChild(node);
}

document.getElementById("new-taco").addEventListener('click',getTaco);