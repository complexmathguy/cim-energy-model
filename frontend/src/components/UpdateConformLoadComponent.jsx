import React, { Component } from 'react'
import ConformLoadService from '../services/ConformLoadService';

class UpdateConformLoadComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateConformLoad = this.updateConformLoad.bind(this);

    }

    componentDidMount(){
        ConformLoadService.getConformLoadById(this.state.id).then( (res) =>{
            let conformLoad = res.data;
            this.setState({
            });
        });
    }

    updateConformLoad = (e) => {
        e.preventDefault();
        let conformLoad = {
            conformLoadId: this.state.id,
        };
        console.log('conformLoad => ' + JSON.stringify(conformLoad));
        console.log('id => ' + JSON.stringify(this.state.id));
        ConformLoadService.updateConformLoad(conformLoad).then( res => {
            this.props.history.push('/conformLoads');
        });
    }


    cancel(){
        this.props.history.push('/conformLoads');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ConformLoad</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateConformLoad}>Save</button>
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

export default UpdateConformLoadComponent
