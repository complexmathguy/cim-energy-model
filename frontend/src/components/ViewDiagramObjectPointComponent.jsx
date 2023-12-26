import React, { Component } from 'react'
import DiagramObjectPointService from '../services/DiagramObjectPointService'

class ViewDiagramObjectPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            diagramObjectPoint: {}
        }
    }

    componentDidMount(){
        DiagramObjectPointService.getDiagramObjectPointById(this.state.id).then( res => {
            this.setState({diagramObjectPoint: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DiagramObjectPoint Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> sequenceNumber:&emsp; </label>
                            <div> { this.state.diagramObjectPoint.sequenceNumber }</div>
                        </div>
                        <div className = "row">
                            <label> xPosition:&emsp; </label>
                            <div> { this.state.diagramObjectPoint.xPosition }</div>
                        </div>
                        <div className = "row">
                            <label> yPosition:&emsp; </label>
                            <div> { this.state.diagramObjectPoint.yPosition }</div>
                        </div>
                        <div className = "row">
                            <label> zPosition:&emsp; </label>
                            <div> { this.state.diagramObjectPoint.zPosition }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDiagramObjectPointComponent
