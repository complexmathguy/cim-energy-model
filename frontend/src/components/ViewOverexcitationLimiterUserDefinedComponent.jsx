import React, { Component } from 'react'
import OverexcitationLimiterUserDefinedService from '../services/OverexcitationLimiterUserDefinedService'

class ViewOverexcitationLimiterUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            overexcitationLimiterUserDefined: {}
        }
    }

    componentDidMount(){
        OverexcitationLimiterUserDefinedService.getOverexcitationLimiterUserDefinedById(this.state.id).then( res => {
            this.setState({overexcitationLimiterUserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View OverexcitationLimiterUserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.overexcitationLimiterUserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewOverexcitationLimiterUserDefinedComponent
