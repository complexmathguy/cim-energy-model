import React, { Component } from 'react'
import ValueToAliasService from '../services/ValueToAliasService';

class UpdateValueToAliasComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                value: ''
        }
        this.updateValueToAlias = this.updateValueToAlias.bind(this);

        this.changevalueHandler = this.changevalueHandler.bind(this);
    }

    componentDidMount(){
        ValueToAliasService.getValueToAliasById(this.state.id).then( (res) =>{
            let valueToAlias = res.data;
            this.setState({
                value: valueToAlias.value
            });
        });
    }

    updateValueToAlias = (e) => {
        e.preventDefault();
        let valueToAlias = {
            valueToAliasId: this.state.id,
            value: this.state.value
        };
        console.log('valueToAlias => ' + JSON.stringify(valueToAlias));
        console.log('id => ' + JSON.stringify(this.state.id));
        ValueToAliasService.updateValueToAlias(valueToAlias).then( res => {
            this.props.history.push('/valueToAliass');
        });
    }

    changevalueHandler= (event) => {
        this.setState({value: event.target.value});
    }

    cancel(){
        this.props.history.push('/valueToAliass');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ValueToAlias</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> value: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateValueToAlias}>Save</button>
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

export default UpdateValueToAliasComponent
