import React, { Component } from 'react'
import TransformerEndService from '../services/TransformerEndService'

class ViewTransformerEndComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            transformerEnd: {}
        }
    }

    componentDidMount(){
        TransformerEndService.getTransformerEndById(this.state.id).then( res => {
            this.setState({transformerEnd: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TransformerEnd Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> endNumber:&emsp; </label>
                            <div> { this.state.transformerEnd.endNumber }</div>
                        </div>
                        <div className = "row">
                            <label> grounded:&emsp; </label>
                            <div> { this.state.transformerEnd.grounded }</div>
                        </div>
                        <div className = "row">
                            <label> rground:&emsp; </label>
                            <div> { this.state.transformerEnd.rground }</div>
                        </div>
                        <div className = "row">
                            <label> xground:&emsp; </label>
                            <div> { this.state.transformerEnd.xground }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTransformerEndComponent
