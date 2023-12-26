import React, { Component } from 'react'
import PssELIN2Service from '../services/PssELIN2Service';

class UpdatePssELIN2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                apss: '',
                ks1: '',
                ks2: '',
                ppss: '',
                psslim: '',
                ts1: '',
                ts2: '',
                ts3: '',
                ts4: '',
                ts5: '',
                ts6: ''
        }
        this.updatePssELIN2 = this.updatePssELIN2.bind(this);

        this.changeapssHandler = this.changeapssHandler.bind(this);
        this.changeks1Handler = this.changeks1Handler.bind(this);
        this.changeks2Handler = this.changeks2Handler.bind(this);
        this.changeppssHandler = this.changeppssHandler.bind(this);
        this.changepsslimHandler = this.changepsslimHandler.bind(this);
        this.changets1Handler = this.changets1Handler.bind(this);
        this.changets2Handler = this.changets2Handler.bind(this);
        this.changets3Handler = this.changets3Handler.bind(this);
        this.changets4Handler = this.changets4Handler.bind(this);
        this.changets5Handler = this.changets5Handler.bind(this);
        this.changets6Handler = this.changets6Handler.bind(this);
    }

    componentDidMount(){
        PssELIN2Service.getPssELIN2ById(this.state.id).then( (res) =>{
            let pssELIN2 = res.data;
            this.setState({
                apss: pssELIN2.apss,
                ks1: pssELIN2.ks1,
                ks2: pssELIN2.ks2,
                ppss: pssELIN2.ppss,
                psslim: pssELIN2.psslim,
                ts1: pssELIN2.ts1,
                ts2: pssELIN2.ts2,
                ts3: pssELIN2.ts3,
                ts4: pssELIN2.ts4,
                ts5: pssELIN2.ts5,
                ts6: pssELIN2.ts6
            });
        });
    }

    updatePssELIN2 = (e) => {
        e.preventDefault();
        let pssELIN2 = {
            pssELIN2Id: this.state.id,
            apss: this.state.apss,
            ks1: this.state.ks1,
            ks2: this.state.ks2,
            ppss: this.state.ppss,
            psslim: this.state.psslim,
            ts1: this.state.ts1,
            ts2: this.state.ts2,
            ts3: this.state.ts3,
            ts4: this.state.ts4,
            ts5: this.state.ts5,
            ts6: this.state.ts6
        };
        console.log('pssELIN2 => ' + JSON.stringify(pssELIN2));
        console.log('id => ' + JSON.stringify(this.state.id));
        PssELIN2Service.updatePssELIN2(pssELIN2).then( res => {
            this.props.history.push('/pssELIN2s');
        });
    }

    changeapssHandler= (event) => {
        this.setState({apss: event.target.value});
    }
    changeks1Handler= (event) => {
        this.setState({ks1: event.target.value});
    }
    changeks2Handler= (event) => {
        this.setState({ks2: event.target.value});
    }
    changeppssHandler= (event) => {
        this.setState({ppss: event.target.value});
    }
    changepsslimHandler= (event) => {
        this.setState({psslim: event.target.value});
    }
    changets1Handler= (event) => {
        this.setState({ts1: event.target.value});
    }
    changets2Handler= (event) => {
        this.setState({ts2: event.target.value});
    }
    changets3Handler= (event) => {
        this.setState({ts3: event.target.value});
    }
    changets4Handler= (event) => {
        this.setState({ts4: event.target.value});
    }
    changets5Handler= (event) => {
        this.setState({ts5: event.target.value});
    }
    changets6Handler= (event) => {
        this.setState({ts6: event.target.value});
    }

    cancel(){
        this.props.history.push('/pssELIN2s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PssELIN2</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> apss: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ks1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ks2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ppss: </label>
                                            #formFields( $attribute, 'update')
                                            <label> psslim: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ts1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ts2: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ts3: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ts4: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ts5: </label>
                                            #formFields( $attribute, 'update')
                                            <label> ts6: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePssELIN2}>Save</button>
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

export default UpdatePssELIN2Component
