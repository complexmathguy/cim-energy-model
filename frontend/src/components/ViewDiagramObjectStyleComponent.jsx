import React, { Component } from 'react'
import DiagramObjectStyleService from '../services/DiagramObjectStyleService'

class ViewDiagramObjectStyleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            diagramObjectStyle: {}
        }
    }

    componentDidMount(){
        DiagramObjectStyleService.getDiagramObjectStyleById(this.state.id).then( res => {
            this.setState({diagramObjectStyle: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DiagramObjectStyle Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDiagramObjectStyleComponent
