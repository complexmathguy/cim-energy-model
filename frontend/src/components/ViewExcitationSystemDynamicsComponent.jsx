import React, { Component } from 'react'
import ExcitationSystemDynamicsService from '../services/ExcitationSystemDynamicsService'

class ViewExcitationSystemDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excitationSystemDynamics: {}
        }
    }

    componentDidMount(){
        ExcitationSystemDynamicsService.getExcitationSystemDynamicsById(this.state.id).then( res => {
            this.setState({excitationSystemDynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcitationSystemDynamics Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcitationSystemDynamicsComponent
