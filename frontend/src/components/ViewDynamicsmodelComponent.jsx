import React, { Component } from 'react'
import DynamicsmodelService from '../services/DynamicsmodelService'

class ViewDynamicsmodelComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dynamicsmodel: {}
        }
    }

    componentDidMount(){
        DynamicsmodelService.getDynamicsmodelById(this.state.id).then( res => {
            this.setState({dynamicsmodel: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Dynamicsmodel Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDynamicsmodelComponent
