import React, { Component } from 'react'
import SynchronousMachineDynamicsService from '../services/SynchronousMachineDynamicsService'

class ViewSynchronousMachineDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            synchronousMachineDynamics: {}
        }
    }

    componentDidMount(){
        SynchronousMachineDynamicsService.getSynchronousMachineDynamicsById(this.state.id).then( res => {
            this.setState({synchronousMachineDynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SynchronousMachineDynamics Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSynchronousMachineDynamicsComponent
