import React, { Component } from 'react'
import WindProtectionIECService from '../services/WindProtectionIECService';

class UpdateWindProtectionIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                fover: '',
                funder: '',
                tfover: '',
                tfunder: '',
                tuover: '',
                tuunder: '',
                uover: '',
                uunder: ''
        }
        this.updateWindProtectionIEC = this.updateWindProtectionIEC.bind(this);

        this.changefoverHandler = this.changefoverHandler.bind(this);
        this.changefunderHandler = this.changefunderHandler.bind(this);
        this.changetfoverHandler = this.changetfoverHandler.bind(this);
        this.changetfunderHandler = this.changetfunderHandler.bind(this);
        this.changetuoverHandler = this.changetuoverHandler.bind(this);
        this.changetuunderHandler = this.changetuunderHandler.bind(this);
        this.changeuoverHandler = this.changeuoverHandler.bind(this);
        this.changeuunderHandler = this.changeuunderHandler.bind(this);
    }

    componentDidMount(){
        WindProtectionIECService.getWindProtectionIECById(this.state.id).then( (res) =>{
            let windProtectionIEC = res.data;
            this.setState({
                fover: windProtectionIEC.fover,
                funder: windProtectionIEC.funder,
                tfover: windProtectionIEC.tfover,
                tfunder: windProtectionIEC.tfunder,
                tuover: windProtectionIEC.tuover,
                tuunder: windProtectionIEC.tuunder,
                uover: windProtectionIEC.uover,
                uunder: windProtectionIEC.uunder
            });
        });
    }

    updateWindProtectionIEC = (e) => {
        e.preventDefault();
        let windProtectionIEC = {
            windProtectionIECId: this.state.id,
            fover: this.state.fover,
            funder: this.state.funder,
            tfover: this.state.tfover,
            tfunder: this.state.tfunder,
            tuover: this.state.tuover,
            tuunder: this.state.tuunder,
            uover: this.state.uover,
            uunder: this.state.uunder
        };
        console.log('windProtectionIEC => ' + JSON.stringify(windProtectionIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindProtectionIECService.updateWindProtectionIEC(windProtectionIEC).then( res => {
            this.props.history.push('/windProtectionIECs');
        });
    }

    changefoverHandler= (event) => {
        this.setState({fover: event.target.value});
    }
    changefunderHandler= (event) => {
        this.setState({funder: event.target.value});
    }
    changetfoverHandler= (event) => {
        this.setState({tfover: event.target.value});
    }
    changetfunderHandler= (event) => {
        this.setState({tfunder: event.target.value});
    }
    changetuoverHandler= (event) => {
        this.setState({tuover: event.target.value});
    }
    changetuunderHandler= (event) => {
        this.setState({tuunder: event.target.value});
    }
    changeuoverHandler= (event) => {
        this.setState({uover: event.target.value});
    }
    changeuunderHandler= (event) => {
        this.setState({uunder: event.target.value});
    }

    cancel(){
        this.props.history.push('/windProtectionIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindProtectionIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> fover: </label>
                                            #formFields( $attribute, 'update')
                                            <label> funder: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tfover: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tfunder: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tuover: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tuunder: </label>
                                            #formFields( $attribute, 'update')
                                            <label> uover: </label>
                                            #formFields( $attribute, 'update')
                                            <label> uunder: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindProtectionIEC}>Save</button>
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

export default UpdateWindProtectionIECComponent
