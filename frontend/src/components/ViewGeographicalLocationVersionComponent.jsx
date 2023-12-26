import React, { Component } from 'react'
import GeographicalLocationVersionService from '../services/GeographicalLocationVersionService'

class ViewGeographicalLocationVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            geographicalLocationVersion: {}
        }
    }

    componentDidMount(){
        GeographicalLocationVersionService.getGeographicalLocationVersionById(this.state.id).then( res => {
            this.setState({geographicalLocationVersion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GeographicalLocationVersion Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> baseUML:&emsp; </label>
                            <div> { this.state.geographicalLocationVersion.baseUML }</div>
                        </div>
                        <div className = "row">
                            <label> baseURI:&emsp; </label>
                            <div> { this.state.geographicalLocationVersion.baseURI }</div>
                        </div>
                        <div className = "row">
                            <label> date:&emsp; </label>
                            <div> { this.state.geographicalLocationVersion.date }</div>
                        </div>
                        <div className = "row">
                            <label> differenceModelURI:&emsp; </label>
                            <div> { this.state.geographicalLocationVersion.differenceModelURI }</div>
                        </div>
                        <div className = "row">
                            <label> entsoeUML:&emsp; </label>
                            <div> { this.state.geographicalLocationVersion.entsoeUML }</div>
                        </div>
                        <div className = "row">
                            <label> entsoeURI:&emsp; </label>
                            <div> { this.state.geographicalLocationVersion.entsoeURI }</div>
                        </div>
                        <div className = "row">
                            <label> modelDescriptionURI:&emsp; </label>
                            <div> { this.state.geographicalLocationVersion.modelDescriptionURI }</div>
                        </div>
                        <div className = "row">
                            <label> namespaceRDF:&emsp; </label>
                            <div> { this.state.geographicalLocationVersion.namespaceRDF }</div>
                        </div>
                        <div className = "row">
                            <label> namespaceUML:&emsp; </label>
                            <div> { this.state.geographicalLocationVersion.namespaceUML }</div>
                        </div>
                        <div className = "row">
                            <label> shortName:&emsp; </label>
                            <div> { this.state.geographicalLocationVersion.shortName }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGeographicalLocationVersionComponent
