import React, { Component } from 'react'
import ValueAliasSetService from '../services/ValueAliasSetService';

class UpdateValueAliasSetComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateValueAliasSet = this.updateValueAliasSet.bind(this);

    }

    componentDidMount(){
        ValueAliasSetService.getValueAliasSetById(this.state.id).then( (res) =>{
            let valueAliasSet = res.data;
            this.setState({
            });
        });
    }

    updateValueAliasSet = (e) => {
        e.preventDefault();
        let valueAliasSet = {
            valueAliasSetId: this.state.id,
        };
        console.log('valueAliasSet => ' + JSON.stringify(valueAliasSet));
        console.log('id => ' + JSON.stringify(this.state.id));
        ValueAliasSetService.updateValueAliasSet(valueAliasSet).then( res => {
            this.props.history.push('/valueAliasSets');
        });
    }


    cancel(){
        this.props.history.push('/valueAliasSets');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ValueAliasSet</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateValueAliasSet}>Save</button>
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

export default UpdateValueAliasSetComponent
