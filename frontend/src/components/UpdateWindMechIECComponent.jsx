import React, { Component } from 'react'
import WindMechIECService from '../services/WindMechIECService';

class UpdateWindMechIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                cdrt: '',
                hgen: '',
                hwtr: '',
                kdrt: ''
        }
        this.updateWindMechIEC = this.updateWindMechIEC.bind(this);

        this.changecdrtHandler = this.changecdrtHandler.bind(this);
        this.changehgenHandler = this.changehgenHandler.bind(this);
        this.changehwtrHandler = this.changehwtrHandler.bind(this);
        this.changekdrtHandler = this.changekdrtHandler.bind(this);
    }

    componentDidMount(){
        WindMechIECService.getWindMechIECById(this.state.id).then( (res) =>{
            let windMechIEC = res.data;
            this.setState({
                cdrt: windMechIEC.cdrt,
                hgen: windMechIEC.hgen,
                hwtr: windMechIEC.hwtr,
                kdrt: windMechIEC.kdrt
            });
        });
    }

    updateWindMechIEC = (e) => {
        e.preventDefault();
        let windMechIEC = {
            windMechIECId: this.state.id,
            cdrt: this.state.cdrt,
            hgen: this.state.hgen,
            hwtr: this.state.hwtr,
            kdrt: this.state.kdrt
        };
        console.log('windMechIEC => ' + JSON.stringify(windMechIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindMechIECService.updateWindMechIEC(windMechIEC).then( res => {
            this.props.history.push('/windMechIECs');
        });
    }

    changecdrtHandler= (event) => {
        this.setState({cdrt: event.target.value});
    }
    changehgenHandler= (event) => {
        this.setState({hgen: event.target.value});
    }
    changehwtrHandler= (event) => {
        this.setState({hwtr: event.target.value});
    }
    changekdrtHandler= (event) => {
        this.setState({kdrt: event.target.value});
    }

    cancel(){
        this.props.history.push('/windMechIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindMechIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> cdrt: </label>
                                            #formFields( $attribute, 'update')
                                            <label> hgen: </label>
                                            #formFields( $attribute, 'update')
                                            <label> hwtr: </label>
                                            #formFields( $attribute, 'update')
                                            <label> kdrt: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindMechIEC}>Save</button>
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

export default UpdateWindMechIECComponent
