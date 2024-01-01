document.addEventListener('DOMContentLoaded', function() {
    fetch('/cartes')
        .then(response => response.json())
        .then(cartes => {
            const container = document.getElementById('cartes-container');
            cartes.forEach(carte => {
                const div = document.createElement('div');
                div.classList.add('carte');
                const couleurClasse = carte.couleur.toLowerCase();
                div.classList.add(couleurClasse);
                div.textContent = `${carte.valeur}`;
                container.appendChild(div);
            });
        })
        .catch(error => {
            console.error(error);
        });
});
