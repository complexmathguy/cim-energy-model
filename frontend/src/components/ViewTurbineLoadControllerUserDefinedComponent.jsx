import React, { Component } from 'react'
import TurbineLoadControllerUserDefinedService from '../services/TurbineLoadControllerUserDefinedService'

class ViewTurbineLoadControllerUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            turbineLoadControllerUserDefined: {}
        }
    }

    componentDidMount(){
        TurbineLoadControllerUserDefinedService.getTurbineLoadControllerUserDefinedById(this.state.id).then( res => {
            this.setState({turbineLoadControllerUserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TurbineLoadControllerUserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.turbineLoadControllerUserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTurbineLoadControllerUserDefinedComponent
