import React, { Component } from 'react'
import PFVArControllerType1DynamicsService from '../services/PFVArControllerType1DynamicsService'

class ViewPFVArControllerType1DynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pFVArControllerType1Dynamics: {}
        }
    }

    componentDidMount(){
        PFVArControllerType1DynamicsService.getPFVArControllerType1DynamicsById(this.state.id).then( res => {
            this.setState({pFVArControllerType1Dynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PFVArControllerType1Dynamics Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPFVArControllerType1DynamicsComponent
