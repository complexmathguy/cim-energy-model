import React, { Component } from 'react'
import DiagramStyleService from '../services/DiagramStyleService'

class ViewDiagramStyleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            diagramStyle: {}
        }
    }

    componentDidMount(){
        DiagramStyleService.getDiagramStyleById(this.state.id).then( res => {
            this.setState({diagramStyle: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DiagramStyle Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDiagramStyleComponent
