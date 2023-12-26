import React, { Component } from 'react'
import PFVArControllerType2UserDefinedService from '../services/PFVArControllerType2UserDefinedService'

class ViewPFVArControllerType2UserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pFVArControllerType2UserDefined: {}
        }
    }

    componentDidMount(){
        PFVArControllerType2UserDefinedService.getPFVArControllerType2UserDefinedById(this.state.id).then( res => {
            this.setState({pFVArControllerType2UserDefined: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View PFVArControllerType2UserDefined Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> proprietary:&emsp; </label>
                            <div> { this.state.pFVArControllerType2UserDefined.proprietary }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPFVArControllerType2UserDefinedComponent
