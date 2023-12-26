import React, { Component } from 'react'
import IdentifiedObjectService from '../services/IdentifiedObjectService'

class ViewIdentifiedObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            identifiedObject: {}
        }
    }

    componentDidMount(){
        IdentifiedObjectService.getIdentifiedObjectById(this.state.id).then( res => {
            this.setState({identifiedObject: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View IdentifiedObject Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> description:&emsp; </label>
                            <div> { this.state.identifiedObject.description }</div>
                        </div>
                        <div className = "row">
                            <label> energyIdentCodeEic:&emsp; </label>
                            <div> { this.state.identifiedObject.energyIdentCodeEic }</div>
                        </div>
                        <div className = "row">
                            <label> mRID:&emsp; </label>
                            <div> { this.state.identifiedObject.mRID }</div>
                        </div>
                        <div className = "row">
                            <label> name:&emsp; </label>
                            <div> { this.state.identifiedObject.name }</div>
                        </div>
                        <div className = "row">
                            <label> shortName:&emsp; </label>
                            <div> { this.state.identifiedObject.shortName }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewIdentifiedObjectComponent
