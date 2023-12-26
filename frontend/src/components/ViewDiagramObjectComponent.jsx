import React, { Component } from 'react'
import DiagramObjectService from '../services/DiagramObjectService'

class ViewDiagramObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            diagramObject: {}
        }
    }

    componentDidMount(){
        DiagramObjectService.getDiagramObjectById(this.state.id).then( res => {
            this.setState({diagramObject: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DiagramObject Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> drawingOrder:&emsp; </label>
                            <div> { this.state.diagramObject.drawingOrder }</div>
                        </div>
                        <div className = "row">
                            <label> isPolygon:&emsp; </label>
                            <div> { this.state.diagramObject.isPolygon }</div>
                        </div>
                        <div className = "row">
                            <label> offsetX:&emsp; </label>
                            <div> { this.state.diagramObject.offsetX }</div>
                        </div>
                        <div className = "row">
                            <label> offsetY:&emsp; </label>
                            <div> { this.state.diagramObject.offsetY }</div>
                        </div>
                        <div className = "row">
                            <label> rotation:&emsp; </label>
                            <div> { this.state.diagramObject.rotation }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDiagramObjectComponent
