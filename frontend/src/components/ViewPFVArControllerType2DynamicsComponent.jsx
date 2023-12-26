import React, { Component } from 'react'
import PFVArControllerType2DynamicsService from '../services/PFVArControllerType2DynamicsService'

class ViewPFVArControllerType2DynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pFVArControllerType2Dynamics: {}
        }
    }

    componentDidMount(){
        PFVArControllerType2DynamicsService.getPFVArControllerType2DynamicsById(this.state.id).then( res => {
            this.setState({pFVArControllerType2Dynamics: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PFVArControllerType2Dynamics Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPFVArControllerType2DynamicsComponent
