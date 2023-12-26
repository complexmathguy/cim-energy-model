import React, { Component } from 'react'
import Simple_FloatService from '../services/Simple_FloatService';

class UpdateSimple_FloatComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                value: ''
        }
        this.updateSimple_Float = this.updateSimple_Float.bind(this);

        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        Simple_FloatService.getSimple_FloatById(this.state.id).then( (res) =>{
            let simple_Float = res.data;
            this.setState({
                value: simple_Float.value
            });
        });
    }

    updateSimple_Float = (e) => {
        e.preventDefault();
        let simple_Float = {
            simple_FloatId: this.state.id,
            value: this.state.value
        };
        console.log('simple_Float => ' + JSON.stringify(simple_Float));
        console.log('id => ' + JSON.stringify(this.state.id));
        Simple_FloatService.updateSimple_Float(simple_Float).then( res => {
            this.props.history.push('/simple_Floats');
        });
    }

    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/simple_Floats');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Simple_Float</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> value: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateSimple_Float}>Save</button>
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

export default UpdateSimple_FloatComponent
