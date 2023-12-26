import React, { Component } from 'react'
import PFVArControllerType1UserDefinedService from '../services/PFVArControllerType1UserDefinedService'

class ViewPFVArControllerType1UserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pFVArControllerType1UserDefined: {}
        }
    }

    componentDidMount(){
        PFVArControllerType1UserDefinedService.getPFVArControllerType1UserDefinedById(this.state.id).then( res => {
            this.setState({pFVArControllerType1UserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PFVArControllerType1UserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.pFVArControllerType1UserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPFVArControllerType1UserDefinedComponent
