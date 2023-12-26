import React, { Component } from 'react'
import TurbineGovernorUserDefinedService from '../services/TurbineGovernorUserDefinedService'

class ViewTurbineGovernorUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            turbineGovernorUserDefined: {}
        }
    }

    componentDidMount(){
        TurbineGovernorUserDefinedService.getTurbineGovernorUserDefinedById(this.state.id).then( res => {
            this.setState({turbineGovernorUserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TurbineGovernorUserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.turbineGovernorUserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTurbineGovernorUserDefinedComponent
