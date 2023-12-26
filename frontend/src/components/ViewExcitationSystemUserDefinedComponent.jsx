import React, { Component } from 'react'
import ExcitationSystemUserDefinedService from '../services/ExcitationSystemUserDefinedService'

class ViewExcitationSystemUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excitationSystemUserDefined: {}
        }
    }

    componentDidMount(){
        ExcitationSystemUserDefinedService.getExcitationSystemUserDefinedById(this.state.id).then( res => {
            this.setState({excitationSystemUserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcitationSystemUserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.excitationSystemUserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcitationSystemUserDefinedComponent
