import React, { Component } from 'react'
import LoadDynamicsService from '../services/LoadDynamicsService'

class ViewLoadDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            loadDynamics: {}
        }
    }

    componentDidMount(){
        LoadDynamicsService.getLoadDynamicsById(this.state.id).then( res => {
            this.setState({loadDynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LoadDynamics Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLoadDynamicsComponent
