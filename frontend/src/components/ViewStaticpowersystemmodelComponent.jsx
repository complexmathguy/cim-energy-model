import React, { Component } from 'react'
import StaticpowersystemmodelService from '../services/StaticpowersystemmodelService'

class ViewStaticpowersystemmodelComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            staticpowersystemmodel: {}
        }
    }

    componentDidMount(){
        StaticpowersystemmodelService.getStaticpowersystemmodelById(this.state.id).then( res => {
            this.setState({staticpowersystemmodel: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Staticpowersystemmodel Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewStaticpowersystemmodelComponent
