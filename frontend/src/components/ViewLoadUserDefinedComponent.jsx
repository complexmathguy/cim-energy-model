import React, { Component } from 'react'
import LoadUserDefinedService from '../services/LoadUserDefinedService'

class ViewLoadUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            loadUserDefined: {}
        }
    }

    componentDidMount(){
        LoadUserDefinedService.getLoadUserDefinedById(this.state.id).then( res => {
            this.setState({loadUserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LoadUserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.loadUserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLoadUserDefinedComponent
