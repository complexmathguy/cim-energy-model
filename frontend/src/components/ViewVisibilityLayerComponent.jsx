import React, { Component } from 'react'
import VisibilityLayerService from '../services/VisibilityLayerService'

class ViewVisibilityLayerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            visibilityLayer: {}
        }
    }

    componentDidMount(){
        VisibilityLayerService.getVisibilityLayerById(this.state.id).then( res => {
            this.setState({visibilityLayer: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View VisibilityLayer Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> drawingOrder:&emsp; </label>
                            <div> { this.state.visibilityLayer.drawingOrder }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewVisibilityLayerComponent
