import React, { Component } from 'react'
import TextDiagramObjectService from '../services/TextDiagramObjectService'

class ViewTextDiagramObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            textDiagramObject: {}
        }
    }

    componentDidMount(){
        TextDiagramObjectService.getTextDiagramObjectById(this.state.id).then( res => {
            this.setState({textDiagramObject: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TextDiagramObject Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> text:&emsp; </label>
                            <div> { this.state.textDiagramObject.text }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTextDiagramObjectComponent
