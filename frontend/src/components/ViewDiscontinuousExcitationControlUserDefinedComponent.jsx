import React, { Component } from 'react'
import DiscontinuousExcitationControlUserDefinedService from '../services/DiscontinuousExcitationControlUserDefinedService'

class ViewDiscontinuousExcitationControlUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            discontinuousExcitationControlUserDefined: {}
        }
    }

    componentDidMount(){
        DiscontinuousExcitationControlUserDefinedService.getDiscontinuousExcitationControlUserDefinedById(this.state.id).then( res => {
            this.setState({discontinuousExcitationControlUserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DiscontinuousExcitationControlUserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.discontinuousExcitationControlUserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDiscontinuousExcitationControlUserDefinedComponent
