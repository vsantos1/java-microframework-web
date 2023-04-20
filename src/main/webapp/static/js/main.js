function getCategories() {
    $.ajax({
        url: "http://localhost:8080/home",
        type: "GET",
        success: (data) => {
            $.each(data, (index, category) => {
                return $("#categorias").append(
                    '<li class="text-center">' +
                    '<a class="icon-link icon-link-hover" href="/categoria/' + category.id + '">' +
                    category.name + '</a>' +
                    '</li>'
                )
            })
        },
        error: () => {
            return $('#categorias').append("<p class='text-dark text-center mt-3'>Erro ao carregar categorias </p>")
                .append("<a  class='btn btn-danger' href='/'>Recarregar</a>")
        }

    })


}

$(document).ready(getCategories());