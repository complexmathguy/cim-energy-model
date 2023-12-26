import React, { Component } from 'react'
import ExtensionVersionService from '../services/ExtensionVersionService';

class UpdateExtensionVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                date: '',
                namespaceURI: ''
        }
        this.updateExtensionVersion = this.updateExtensionVersion.bind(this);

        this.changedateHandler = this.changedateHandler.bind(this);
        this.changenamespaceURIHandler = this.changenamespaceURIHandler.bind(this);
    }

    componentDidMount(){
        ExtensionVersionService.getExtensionVersionById(this.state.id).then( (res) =>{
            let extensionVersion = res.data;
            this.setState({
                date: extensionVersion.date,
                namespaceURI: extensionVersion.namespaceURI
            });
        });
    }

    updateExtensionVersion = (e) => {
        e.preventDefault();
        let extensionVersion = {
            extensionVersionId: this.state.id,
            date: this.state.date,
            namespaceURI: this.state.namespaceURI
        };
        console.log('extensionVersion => ' + JSON.stringify(extensionVersion));
        console.log('id => ' + JSON.stringify(this.state.id));
        ExtensionVersionService.updateExtensionVersion(extensionVersion).then( res => {
            this.props.history.push('/extensionVersions');
        });
    }

    changedateHandler= (event) => {
        this.setState({date: event.target.value});
    }
    changenamespaceURIHandler= (event) => {
        this.setState({namespaceURI: event.target.value});
    }

    cancel(){
        this.props.history.push('/extensionVersions');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ExtensionVersion</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> date: </label>
                                            #formFields( $attribute, 'update')
                                            <label> namespaceURI: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateExtensionVersion}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateExtensionVersionComponent
