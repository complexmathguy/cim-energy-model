import React, { Component } from 'react'
import DiagramObjectGluePointService from '../services/DiagramObjectGluePointService'

class ViewDiagramObjectGluePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            diagramObjectGluePoint: {}
        }
    }

    componentDidMount(){
        DiagramObjectGluePointService.getDiagramObjectGluePointById(this.state.id).then( res => {
            this.setState({diagramObjectGluePoint: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DiagramObjectGluePoint Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDiagramObjectGluePointComponent
