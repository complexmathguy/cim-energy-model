import React, { Component } from 'react'
import LimitService from '../services/LimitService';

class UpdateLimitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateLimit = this.updateLimit.bind(this);

    }

    componentDidMount(){
        LimitService.getLimitById(this.state.id).then( (res) =>{
            let limit = res.data;
            this.setState({
            });
        });
    }

    updateLimit = (e) => {
        e.preventDefault();
        let limit = {
            limitId: this.state.id,
        };
        console.log('limit => ' + JSON.stringify(limit));
        console.log('id => ' + JSON.stringify(this.state.id));
        LimitService.updateLimit(limit).then( res => {
            this.props.history.push('/limits');
        });
    }


    cancel(){
        this.props.history.push('/limits');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Limit</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateLimit}>Save</button>
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

export default UpdateLimitComponent
