import React, { Component } from 'react'
import MechanicalLoadUserDefinedService from '../services/MechanicalLoadUserDefinedService'

class ViewMechanicalLoadUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            mechanicalLoadUserDefined: {}
        }
    }

    componentDidMount(){
        MechanicalLoadUserDefinedService.getMechanicalLoadUserDefinedById(this.state.id).then( res => {
            this.setState({mechanicalLoadUserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View MechanicalLoadUserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.mechanicalLoadUserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewMechanicalLoadUserDefinedComponent
