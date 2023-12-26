import React, { Component } from 'react'
import MechLoad1Service from '../services/MechLoad1Service';

class UpdateMechLoad1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                a: '',
                b: '',
                d: '',
                e: ''
        }
        this.updateMechLoad1 = this.updateMechLoad1.bind(this);

        this.changeaHandler = this.changeaHandler.bind(this);
        this.changebHandler = this.changebHandler.bind(this);
        this.changedHandler = this.changedHandler.bind(this);
        this.changeeHandler = this.changeeHandler.bind(this);
    }

    componentDidMount(){
        MechLoad1Service.getMechLoad1ById(this.state.id).then( (res) =>{
            let mechLoad1 = res.data;
            this.setState({
                a: mechLoad1.a,
                b: mechLoad1.b,
                d: mechLoad1.d,
                e: mechLoad1.e
            });
        });
    }

    updateMechLoad1 = (e) => {
        e.preventDefault();
        let mechLoad1 = {
            mechLoad1Id: this.state.id,
            a: this.state.a,
            b: this.state.b,
            d: this.state.d,
            e: this.state.e
        };
        console.log('mechLoad1 => ' + JSON.stringify(mechLoad1));
        console.log('id => ' + JSON.stringify(this.state.id));
        MechLoad1Service.updateMechLoad1(mechLoad1).then( res => {
            this.props.history.push('/mechLoad1s');
        });
    }

    changeaHandler= (event) => {
        this.setState({a: event.target.value});
    }
    changebHandler= (event) => {
        this.setState({b: event.target.value});
    }
    changedHandler= (event) => {
        this.setState({d: event.target.value});
    }
    changeeHandler= (event) => {
        this.setState({e: event.target.value});
    }

    cancel(){
        this.props.history.push('/mechLoad1s');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update MechLoad1</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> a: </label>
                                            #formFields( $attribute, 'update')
                                            <label> b: </label>
                                            #formFields( $attribute, 'update')
                                            <label> d: </label>
                                            #formFields( $attribute, 'update')
                                            <label> e: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateMechLoad1}>Save</button>
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

export default UpdateMechLoad1Component
