import React, { Component } from 'react'
import DomainVersionService from '../services/DomainVersionService';

class UpdateDomainVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                baseUML: '',
                date: '',
                entsoeUML: '',
                version: ''
        }
        this.updateDomainVersion = this.updateDomainVersion.bind(this);

        this.changebaseUMLHandler = this.changebaseUMLHandler.bind(this);
        this.changedateHandler = this.changedateHandler.bind(this);
        this.changeentsoeUMLHandler = this.changeentsoeUMLHandler.bind(this);
        this.changeversionHandler = this.changeversionHandler.bind(this);
    }

    componentDidMount(){
        DomainVersionService.getDomainVersionById(this.state.id).then( (res) =>{
            let domainVersion = res.data;
            this.setState({
                baseUML: domainVersion.baseUML,
                date: domainVersion.date,
                entsoeUML: domainVersion.entsoeUML,
                version: domainVersion.version
            });
        });
    }

    updateDomainVersion = (e) => {
        e.preventDefault();
        let domainVersion = {
            domainVersionId: this.state.id,
            baseUML: this.state.baseUML,
            date: this.state.date,
            entsoeUML: this.state.entsoeUML,
            version: this.state.version
        };
        console.log('domainVersion => ' + JSON.stringify(domainVersion));
        console.log('id => ' + JSON.stringify(this.state.id));
        DomainVersionService.updateDomainVersion(domainVersion).then( res => {
            this.props.history.push('/domainVersions');
        });
    }

    changebaseUMLHandler= (event) => {
        this.setState({baseUML: event.target.value});
    }
    changedateHandler= (event) => {
        this.setState({date: event.target.value});
    }
    changeentsoeUMLHandler= (event) => {
        this.setState({entsoeUML: event.target.value});
    }
    changeversionHandler= (event) => {
        this.setState({version: event.target.value});
    }

    cancel(){
        this.props.history.push('/domainVersions');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DomainVersion</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> baseUML: </label>
                                            #formFields( $attribute, 'update')
                                            <label> date: </label>
                                            #formFields( $attribute, 'update')
                                            <label> entsoeUML: </label>
                                            #formFields( $attribute, 'update')
                                            <label> version: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDomainVersion}>Save</button>
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

export default UpdateDomainVersionComponent
