import React, { Component } from 'react'
import WindProtectionIECService from '../services/WindProtectionIECService';

class CreateWindProtectionIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
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
        this.changefoverHandler = this.changefoverHandler.bind(this);
        this.changefunderHandler = this.changefunderHandler.bind(this);
        this.changetfoverHandler = this.changetfoverHandler.bind(this);
        this.changetfunderHandler = this.changetfunderHandler.bind(this);
        this.changetuoverHandler = this.changetuoverHandler.bind(this);
        this.changetuunderHandler = this.changetuunderHandler.bind(this);
        this.changeuoverHandler = this.changeuoverHandler.bind(this);
        this.changeuunderHandler = this.changeuunderHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdateWindProtectionIEC = (e) => {
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

        // step 5
        if(this.state.id === '_add'){
            windProtectionIEC.windProtectionIECId=''
            WindProtectionIECService.createWindProtectionIEC(windProtectionIEC).then(res =>{
                this.props.history.push('/windProtectionIECs');
            });
        }else{
            WindProtectionIECService.updateWindProtectionIEC(windProtectionIEC).then( res => {
                this.props.history.push('/windProtectionIECs');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add WindProtectionIEC</h3>
        }else{
            return <h3 className="text-center">Update WindProtectionIEC</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> fover: </label>
                                            #formFields( $attribute, 'create')
                                            <label> funder: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tfover: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tfunder: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tuover: </label>
                                            #formFields( $attribute, 'create')
                                            <label> tuunder: </label>
                                            #formFields( $attribute, 'create')
                                            <label> uover: </label>
                                            #formFields( $attribute, 'create')
                                            <label> uunder: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateWindProtectionIEC}>Save</button>
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

export default CreateWindProtectionIECComponent
