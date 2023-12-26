import React, { Component } from 'react'
import DiscontinuousExcitationControlDynamicsService from '../services/DiscontinuousExcitationControlDynamicsService'

class ViewDiscontinuousExcitationControlDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            discontinuousExcitationControlDynamics: {}
        }
    }

    componentDidMount(){
        DiscontinuousExcitationControlDynamicsService.getDiscontinuousExcitationControlDynamicsById(this.state.id).then( res => {
            this.setState({discontinuousExcitationControlDynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DiscontinuousExcitationControlDynamics Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDiscontinuousExcitationControlDynamicsComponent
