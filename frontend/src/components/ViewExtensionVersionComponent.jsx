import React, { Component } from 'react'
import ExtensionVersionService from '../services/ExtensionVersionService'

class ViewExtensionVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            extensionVersion: {}
        }
    }

    componentDidMount(){
        ExtensionVersionService.getExtensionVersionById(this.state.id).then( res => {
            this.setState({extensionVersion: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExtensionVersion Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> date:&emsp; </label>
                            <div> { this.state.extensionVersion.date }</div>
                        </div>
                        <div className = "row">
                            <label> namespaceURI:&emsp; </label>
                            <div> { this.state.extensionVersion.namespaceURI }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExtensionVersionComponent
