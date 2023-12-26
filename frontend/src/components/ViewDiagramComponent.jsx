import React, { Component } from 'react'
import DiagramService from '../services/DiagramService'

class ViewDiagramComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            diagram: {}
        }
    }

    componentDidMount(){
        DiagramService.getDiagramById(this.state.id).then( res => {
            this.setState({diagram: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Diagram Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> orientation:&emsp; </label>
                            <div> { this.state.diagram.orientation }</div>
                        </div>
                        <div className = "row">
                            <label> x1InitialView:&emsp; </label>
                            <div> { this.state.diagram.x1InitialView }</div>
                        </div>
                        <div className = "row">
                            <label> x2InitialView:&emsp; </label>
                            <div> { this.state.diagram.x2InitialView }</div>
                        </div>
                        <div className = "row">
                            <label> y1InitialView:&emsp; </label>
                            <div> { this.state.diagram.y1InitialView }</div>
                        </div>
                        <div className = "row">
                            <label> y2InitialView:&emsp; </label>
                            <div> { this.state.diagram.y2InitialView }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDiagramComponent
