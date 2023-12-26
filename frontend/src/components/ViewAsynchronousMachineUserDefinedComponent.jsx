import React, { Component } from 'react'
import AsynchronousMachineUserDefinedService from '../services/AsynchronousMachineUserDefinedService'

class ViewAsynchronousMachineUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            asynchronousMachineUserDefined: {}
        }
    }

    componentDidMount(){
        AsynchronousMachineUserDefinedService.getAsynchronousMachineUserDefinedById(this.state.id).then( res => {
            this.setState({asynchronousMachineUserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View AsynchronousMachineUserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.asynchronousMachineUserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAsynchronousMachineUserDefinedComponent
